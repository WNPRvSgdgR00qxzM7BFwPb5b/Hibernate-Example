package pl.sda.sapiens.ep.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import pl.sda.sapiens.ep.model.entity.TagEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Repository
class HibernateTagRepository implements TagRepository {


    private final EntityManager entityManager;
    private final EntityTransaction transaction;

    HibernateTagRepository(SessionFactory sessionFactory) {
        entityManager = sessionFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    @Override
    public TagEntity saveIfNotPresent(String tag) {
        transaction.begin();

        try {
            TypedQuery<TagEntity> query = entityManager.createQuery("select t from tag t where t.name = :tagName", TagEntity.class);
            query.setParameter("tagName", tag);
            return query.getSingleResult();

        } catch (NoResultException e) {
            TagEntity newTag = new TagEntity(0, tag, null);
            entityManager.persist(newTag);
            return newTag;

        } finally {
            transaction.commit();
        }


    }
}
