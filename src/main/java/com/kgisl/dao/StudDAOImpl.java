package com.kgisl.dao;

import java.util.List;

import com.kgisl.model.Student;
import com.kgisl.dao.StudDAO;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudDAOImpl implements StudDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public StudDAOImpl() {
		
	}
	
	public StudDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Transactional
    public List<Student> list() {
		@SuppressWarnings("unchecked")
		List<Student> listUser = (List<Student>) sessionFactory.getCurrentSession()
				.createCriteria(Student.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	
	@Transactional
	public void saveOrUpdate(Student stud) {
		sessionFactory.getCurrentSession().saveOrUpdate(stud);
	}

	
	@Transactional
	public void delete(int id) {
		Student userToDelete = new Student();
		userToDelete.setStudentid(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
	}

	
	@Transactional
	public Student get(int id) {
		String hql = "from Student where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Student> listUser = (List<Student>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		
		return null;
	}
}