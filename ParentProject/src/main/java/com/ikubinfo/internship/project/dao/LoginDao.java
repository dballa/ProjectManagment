package com.ikubinfo.internship.project.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ikubinfo.internship.project.converter.UserConverter;
import com.ikubinfo.internship.project.entity.PermissionEntity;
import com.ikubinfo.internship.project.entity.UserEntity;
import com.ikubinfo.internship.project.pojo.User;

@Repository
@Transactional
public class LoginDao {
	@Autowired
	private SessionFactory sessionFactory;

	private UserConverter USER_CONVERTER = new UserConverter();

	public User login(User userPojo) {
		try {
			Query<UserEntity> query = sessionFactory.getCurrentSession()
					.createQuery("from UserEntity where email=?1 and password=?2 and validity=1", UserEntity.class);

			query.setParameter(1, userPojo.getEmail());
			query.setParameter(2, userPojo.getPassword());
			UserEntity user = query.getSingleResult();
			if (user == null)
				return null;

			return USER_CONVERTER.fromEntityToPojo(user);
		} catch (NoResultException nre) {
			return null;
		}

	}

	public List<PermissionEntity> findPermissions(User user) {

		Session session = sessionFactory.getCurrentSession();
		String sql = "select NamePermission from permission inner join permissionrole on permission.IdPermission=permissionrole.IdPermission inner join user on user.IdRole=permissionrole.IdRole and user.IdUser= :idUser";
		Query<PermissionEntity> query = (Query<PermissionEntity>) session.createSQLQuery(sql).setParameter("idUser",
				user.getIdUser());

		List<PermissionEntity> permissionsFound = query.list();

		return permissionsFound;

	}
}
