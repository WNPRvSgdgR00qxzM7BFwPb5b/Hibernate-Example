package pl.sda.sapiens.ep.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import pl.sda.sapiens.ep.model.entity.EventEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
class HibernateEventRepository implements EventRepository {


    private final EntityManager entityManager;
    private final EntityTransaction transaction;

    HibernateEventRepository(SessionFactory sessionFactory) {
        entityManager = sessionFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    @Override
    public void save(EventEntity entity) {
        try {
            transaction.begin();
            entityManager.persist(entity);
        } finally {
            transaction.commit();
        }
    }

    @Override
    public List<EventEntity> findAllEventEntity() {
        try {
            transaction.begin();
            return entityManager.createQuery("SELECT e FROM event e", EventEntity.class).getResultList();
        } finally {
            transaction.commit();
        }
    }
}
