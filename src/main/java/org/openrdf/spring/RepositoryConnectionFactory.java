package org.openrdf.spring;

import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.transaction.TransactionSystemException;

/**
 * <p>{@link RepositoryConnectionFactory} handles connections to a single corresponding {@link Repository} and manages
 * the transaction state (represented by {@link SesameTransactionObject}).</p>
 * <p/>
 * <p>This class provides methods to access <i>transactional</i> connections from the outside and is typically the
 * only class that library users interact with.</p>
 *
 * @author ameingast@gmail.com
 * @see SesameConnectionFactory
 */
public class RepositoryConnectionFactory implements DisposableBean, SesameConnectionFactory {
    private final ThreadLocal<SesameTransactionObject> localTransactionObject;

    private final Repository repository;

    /**
     * <p>Creates a new {@link RepositoryConnectionFactory} for the provided {@link Repository}.</p>
     *
     * @param repository The repository to which connections are opened.
     */
    public RepositoryConnectionFactory(Repository repository) {
        this.repository = repository;
        localTransactionObject = new ThreadLocal<SesameTransactionObject>();
    }

    /**
     * @inheritDoc
     */
    public RepositoryConnection getConnection() {
        SesameTransactionObject sesameTransactionObject = localTransactionObject.get();

        if (sesameTransactionObject == null) {
            throw new SesameTransactionException("No transaction active");
        }

        RepositoryConnection repositoryConnection = sesameTransactionObject.getRepositoryConnection();

        try {
            if (!repositoryConnection.isOpen()) {
                throw new SesameTransactionException("Connection closed during transaction");
            }

            if (!repositoryConnection.isActive()) {
                repositoryConnection.begin();
            }
        } catch (RepositoryException e) {
            throw new SesameTransactionException(e);
        }

        return repositoryConnection;
    }

    /**
     * @inheritDoc
     */
    public void closeConnection() {
        SesameTransactionObject sesameTransactionObject = null;
        RepositoryConnection repositoryConnection = null;

        try {
            sesameTransactionObject = localTransactionObject.get();

            if (sesameTransactionObject == null) {
                throw new SesameTransactionException("No transaction active");
            }

            repositoryConnection = sesameTransactionObject.getRepositoryConnection();

            try {
                if (!repositoryConnection.isOpen()) {
                    throw new SesameTransactionException("Connection closed during transaction");
                }
            } catch (RepositoryException e) {
                throw new SesameTransactionException(e);
            }
        } finally {
            if (sesameTransactionObject != null && repositoryConnection != null) {
                try {
                    repositoryConnection.close();
                } catch (RepositoryException e) {
                    throw new SesameTransactionException(e);
                }

                localTransactionObject.remove();
            }
        }
    }

    /**
     * @inheritDoc
     */
    public SesameTransactionObject createTransaction() throws RepositoryException {
        RepositoryConnection repositoryConnection = repository.getConnection();

        SesameTransactionObject sesameTransactionObject = new SesameTransactionObject(repositoryConnection);
        localTransactionObject.set(sesameTransactionObject);

        return sesameTransactionObject;
    }

    /**
     * @inheritDoc
     */
    
    public void endTransaction(boolean rollback) throws RepositoryException {
        SesameTransactionObject sesameTransactionObject = localTransactionObject.get();

        if (sesameTransactionObject == null) {
            throw new TransactionSystemException("No transaction active");
        }

        RepositoryConnection repositoryConnection = sesameTransactionObject.getRepositoryConnection();

        if (!repositoryConnection.isOpen()) {
            throw new SesameTransactionException("Connection closed during transaction");
        }

        if (repositoryConnection.isActive()) {
            if (rollback) {
                repositoryConnection.rollback();
            } else {
                repositoryConnection.commit();
            }
        }
    }

    /**
     * @inheritDoc
     */
    
    public SesameTransactionObject getLocalTransactionObject() {
        return localTransactionObject.get();
    }

    /**
     * <p>Shuts down the associated {@link Repository} if it was initialized before.</p>
     *
     * @throws Exception {@see Repository#shutDown}
     */
    
    public void destroy() throws Exception {
        if (repository != null && repository.isInitialized()) {
            repository.shutDown();
        }
    }

    @Override
    public String toString() {
        return "RepositoryConnectionFactory{" +
                "repository=" + repository +
                ", localTransactionObject=" + localTransactionObject +
                '}';
    }
}
