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
package com.a2a.adjava.generator.core.xmlanalyser.xa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.a2a.adjava.AdjavaException;
import com.a2a.adjava.generator.core.xmlmerge.xa.configuration.loader.ConfigurationLoader;
import com.a2a.adjava.generator.core.xmlmerge.xa.configuration.model.XAConfiguration;
import com.a2a.adjava.generator.core.xmlmerge.xa.xmlfile.loader.XmlFileLoader;
import com.a2a.adjava.generator.core.xmlmerge.xa.xmlfile.model.XAFiles;
import com.a2a.adjava.generator.core.xmlmerge.xa.xmlfile.process.MergeProcessor;

import static com.a2a.adjava.generator.core.xmlanalyser.xa.ConstantPaths.ROOT_DIV;
import static com.a2a.adjava.generator.core.xmlanalyser.xa.ConstantPaths.ROOT_IOS;

public class TestMergeProcessorStoryboard {
	
	@Before
	public void load() throws AdjavaException {
		XAConfiguration.getInstance().clear();
		ConfigurationLoader oLoaderTest = new ConfigurationLoader(Paths.get(ConstantPaths.ROOT_CONF));
		oLoaderTest.load();
		Assert.assertFalse(oLoaderTest.hasError());
		ConfigurationLoader oLoaderSrc = new ConfigurationLoader(Paths.get(ConstantPaths.ROOT_CONF_MAIN));
		oLoaderSrc.load();
		Assert.assertFalse(oLoaderSrc.hasError());

		XmlFileLoader oXmlLoaderOldGen = new XmlFileLoader(Paths.get(ROOT_IOS+"/oldgen"), XmlFileLoader.Type.OLDGEN,"storyboard","storyboard.xml");
		XmlFileLoader oXmlLoaderMod = new XmlFileLoader(Paths.get(ROOT_IOS+"/mod"),  XmlFileLoader.Type.MOD,"storyboard","storyboard.xml");
		XmlFileLoader oXmlLoaderNewGen = new XmlFileLoader(Paths.get(ROOT_IOS+"/newgen"),  XmlFileLoader.Type.NEWGEN,"storyboard","storyboard.xml");

		oXmlLoaderOldGen.load();
		Assert.assertFalse(oXmlLoaderOldGen.hasError());
		oXmlLoaderNewGen.load();
		Assert.assertFalse(oXmlLoaderNewGen.hasError());
		oXmlLoaderMod.load();
		Assert.assertFalse(oXmlLoaderMod.hasError());
	}
	
	@Test
	public void testMergeProcessor() {
		testMergeProcessor("storyboard.storyboard");
		testMergeProcessor("Main.storyboard");
		testMergeProcessor("MainStoryBoard.storyboard");
	}
	
	private void testMergeProcessor(String fileName) {
		File oFileResult = new File(ROOT_IOS+"/expected/"+fileName);
		File oFile = new File(ROOT_IOS+"/newmod/"+fileName);
		if (oFile.exists()) {
			oFile.delete();
		}
		MergeProcessor oMp = new MergeProcessor();
				
		try {
			oMp.process(Paths.get(ROOT_IOS+"/oldgen",fileName), Paths.get(ROOT_IOS+"/newgen",fileName), Paths.get(ROOT_IOS+"/mod/"+fileName), Paths.get(ROOT_IOS+"/newmod/"+fileName));
		} catch (AdjavaException e1) {
			e1.printStackTrace();
		}
		Assert.assertTrue(oFile.exists());
		
		String sFileResult = null;
		String sFile = null;
		try {
			FileReader oFrr = new FileReader(oFileResult);
			try {
				StringBuilder oSb = new StringBuilder();
				char c = (char) oFrr.read();
				while(c!=65535) {
					oSb.append(c);
					c = (char) oFrr.read();
				}
				sFileResult = oSb.toString().trim();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				oFrr.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileReader oFrr = new FileReader(oFile);
			try {
				StringBuilder oSb = new StringBuilder();
				char c = (char) oFrr.read();
				while(c!=65535) {
					oSb.append(c);
					c = (char) oFrr.read();
				}
				sFile = oSb.toString().trim();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				oFrr.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sFileResult = sFileResult.replaceAll("\\n", " ");
		sFileResult = sFileResult.replaceAll(">\\s*<", "><");
		sFile = sFile.replaceAll("\\n", " ");
		sFile = sFile.replaceAll(">\\s*<", "><");
		
		Assert.assertEquals(sFileResult, sFile);
	}
	@After
	public void unload() {
		XAConfiguration.getInstance().clear();
		XAFiles.getInstance().clear();
	}
}
