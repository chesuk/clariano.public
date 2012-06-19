/**
 *  Copyright 2012 Phil Spencer
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.clariano.avaj;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class ByteStreamStructureLearner {
	private final byte[] bytes;
	private final File classfile;

	public ByteStreamStructureLearner(File classFile) {
		this.classfile = classFile;
		try {
			bytes = FileUtils.readFileToByteArray(this.classfile);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	
	public void learn() {
		// Check for the CAFEBABE magic number
		if ((bytes[0]&0xFF)==0xCA && (bytes[1]&0xFF)==0xFE && (bytes[2]&0xFF)==0xBA && (bytes[3]&0xFF)==0xBE) {
			System.err.println(this.classfile.getAbsolutePath()+ " is a Java class file");
		} else {
			System.err.println(this.classfile.getAbsolutePath()+ " is not a Java class file");
		}
	}

}
