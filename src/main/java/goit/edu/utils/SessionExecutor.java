package goit.edu.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.function.Consumer;
import java.util.function.Function;

public final class SessionExecutor {
    private final SessionFactory factory;

    public SessionExecutor(SessionFactory factory) {
        this.factory = factory;
    }

    public <T> T read(Function<Session, T> action) {
        try (Session session = factory.openSession()) {
            return action.apply(session);
        }
    }

    public <T> T writeWithReturn(Function<Session, T> action) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            T result = action.apply(session);
            tx.commit();
            return result;
        } catch (RuntimeException ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw ex;
        }
    }

    public void writeWithoutReturn(Consumer<Session> action) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            action.accept(session);
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw ex;
        }
    }
}
