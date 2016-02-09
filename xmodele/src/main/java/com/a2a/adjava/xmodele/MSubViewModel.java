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
package com.a2a.adjava.xmodele;

/**
 * Permet de contruire un view model
 * @author smaitre
 *
 */
public class MSubViewModel extends SClass<MViewModelInterface,MMethodSignature> {
	
	/**
	 * Construit un nouveau view model
	 * @param p_sName
	 * @param p_oPackage
	 */
	public MSubViewModel(String p_sName, MPackage p_oPackage) {
		super("subviewmodel", null, p_sName, p_oPackage);
	}
}