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
package com.a2a.adjava.optionsetters;

import java.util.Map;

import com.a2a.adjava.AdjavaException;
import com.a2a.adjava.languages.LanguageConfiguration;


/**
 * <p>Applique les options à un attribut</p>
 *
 * <p>Copyright (c) 2009
 * <p>Company: Adeuza
 *
 * @author lmichenaud
 * @param <T> type d'objet auquel s'applique l'option
 */

public interface OptionSetter<T extends Object> {

	/**
	 * Applique les options contenues dans la map à l'attribut
	 * @param p_mapOptions Map des options
	 * @param p_oElem attribut à mettre à jour
	 * @param p_oLngConf language configuration
	 * @throws Exception échec d'application des options
	 */
	public void applyOptions( Map<String,?> p_mapOptions, T p_oElem, LanguageConfiguration p_oLngConf ) throws AdjavaException;
	
	/**
	 * Retourne les paramètres du MAttributeOptionSetter
	 * 
	 * @return Objet parametersMap
	 */
	public Map<String, String> getParameters();

	/**
	 * Définit les paramètres du MAttributOptionSetter
	 * 
	 * @param p_mapParameters Objet parametersMap
	 */
	public void setParametersMap(Map<String, String> p_mapParameters);
}
