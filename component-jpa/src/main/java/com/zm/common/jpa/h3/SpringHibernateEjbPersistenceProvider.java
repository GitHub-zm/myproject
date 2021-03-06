package com.zm.common.jpa.h3;

import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceUnitInfo;

import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.orm.jpa.persistenceunit.SmartPersistenceUnitInfo;

import com.zm.common.jpa.hibernate.TrimStringType;

/**
 * Spring-specific subclass of the standard {@link HibernatePersistence}
 * provider from the {@code org.hibernate.ejb} package, adding support for
 * {@link SmartPersistenceUnitInfo#getManagedPackages()}.
 * 
 * <p>
 * Compatible with Hibernate 3.6 as well as 4.0-4.2.
 * 
 * <p>
 * 解决数据库char定长字符串类型去空格问题。
 * 
 * @author Juergen Hoeller
 * @author Joris Kuipers
 * @since 4.1
 * @see Ejb3Configuration#addPackage
 */
public class SpringHibernateEjbPersistenceProvider extends HibernatePersistence {

	public EntityManagerFactory createContainerEntityManagerFactory(PersistenceUnitInfo info, Map properties) {
		Ejb3Configuration cfg = new Ejb3Configuration();

		this.registerTypeOverride(cfg);

		Ejb3Configuration configured = cfg.configure(info, properties);
		return configured != null ? configured.buildEntityManagerFactory() : null;
	}

	/**
	 * 注册类型覆盖。
	 * 
	 * @param cfg
	 */
	private void registerTypeOverride(Ejb3Configuration cfg) {
		cfg.getHibernateConfiguration().registerTypeOverride(TrimStringType.INSTANCE);
	}
}
