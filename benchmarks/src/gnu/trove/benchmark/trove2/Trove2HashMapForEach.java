// ////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2009, Rob Eden All Rights Reserved.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
// ////////////////////////////////////////////////////////////////////////////

package gnu.trove.benchmark.trove2;

import gnu.trove.TIntObjectHashMap;
import gnu.trove.TIntObjectProcedure;
import gnu.trove.benchmark.Benchmark;
import gnu.trove.benchmark.BenchmarkRunner;


/**
 *
 */
public class Trove2HashMapForEach implements Benchmark {
	private TIntObjectHashMap<Integer> map = new TIntObjectHashMap<Integer>();
	private Totaler totaler = new Totaler();

	public boolean isAvailable() {
		return true;
	}

	public void setUp() {
		if ( !map.isEmpty() ) return;

		for( int j = 0; j < 2; j++ ) {
			for( Integer i : BenchmarkRunner.INTEGERS ) {
				map.put( i.intValue(), i );
			}
		}
	}

	public void tearDown() {}

	public String getName() {
		return "Trove2 HashMap ForEach";
	}

	public void run() {
		totaler.reset();

		for( int i = 0; i < 5; i++ ) {
			map.forEachEntry( totaler );
		}
	}

	class Totaler implements TIntObjectProcedure<Integer> {
		int total = 0;

		void reset() {
			total = 0;
		}

		public boolean execute( int a, Integer b ) {
			total += a;
			return true;
		}
	}
}