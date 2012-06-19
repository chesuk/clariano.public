package com.clariano.avaj;

import java.io.File;

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

public class Avaj {
	public Avaj(String classFilePath) {
		ByteStreamStructureLearner bsl = new ByteStreamStructureLearner(new File(classFilePath));
		bsl.learn();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length!=0) {
			for (int ix = 0; ix < args.length; ix++) {
				new Avaj(args[ix]);
			}
		} else {
			usage();
		}
	}

	private static void usage() {
		System.err.println("Usage:");
		System.err.println("\tAVaj <class file list>");
	}

}
