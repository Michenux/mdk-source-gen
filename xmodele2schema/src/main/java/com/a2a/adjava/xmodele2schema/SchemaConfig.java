/**
 * Copyright (C) 2010 Sopra Steria Group (movalys.support@soprasteria.com)
 *
 * This file is part of Movalys MDK.
 * Movalys MDK is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Movalys MDK is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with Movalys MDK. If not, see <http://www.gnu.org/licenses/>.
 */
package com.a2a.adjava.xmodele2schema;

import com.a2a.adjava.schema.SchemaFactory;
import com.a2a.adjava.schema.naming.DbNamingStrategy;

/**
 * <p>Schema configuration</p>
 *
 * <p>Copyright (c) 2011
 * <p>Company: Adeuza
 *
 * @author lmichenaud
 *
 */

public class SchemaConfig {

	/**
	 * Factory for schema objects
	 */
	private SchemaFactory schemaFactory ;
	
	/**
	 * Strategy for naming database objects
	 */
	private DbNamingStrategy dbNamingStrategyClass ;

	/**
	 * Retourne l'objet schemaFactory
	 * @return Objet schemaFactory
	 */
	public SchemaFactory getSchemaFactory() {
		return this.schemaFactory;
	}

	/**
	 * Affecte l'objet schemaFactory 
	 * @param p_oSchemaFactory Objet schemaFactory
	 */
	public void setSchemaFactory(SchemaFactory p_oSchemaFactory) {
		this.schemaFactory = p_oSchemaFactory;
	}

	/**
	 * Retourne l'objet dbNamingStrategyClass
	 * @return Objet dbNamingStrategyClass
	 */
	public DbNamingStrategy getDbNamingStrategyClass() {
		return this.dbNamingStrategyClass;
	}

	/**
	 * Affecte l'objet dbNamingStrategyClass 
	 * @param p_oDbNamingStrategyClass Objet dbNamingStrategyClass
	 */
	public void setDbNamingStrategyClass(DbNamingStrategy p_oDbNamingStrategyClass) {
		this.dbNamingStrategyClass = p_oDbNamingStrategyClass;
	}
}
