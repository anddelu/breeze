package scalanlp.classify;

/*
 Copyright 2009 David Hall, Daniel Ramage
 
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at 
 
 http://www.apache.org/licenses/LICENSE-2.0
 
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License. 
*/


import counters._;
import data._;

/**
 * Represents a classifier from observations of type T to labels of type L.
 * Implementers should only need to implement score.
 * 
 * @author dlwh
 */
trait Classifier[L,-T] extends (T=>L) {
  /** Return the most likely label */
  def apply(o :T) = classify(o);
  /** Return the most likely label */
  def classify(o :T) = scores(o).argmax;
  /** For the observation, return the score for each label that has a nonzero 
   *  score. 
   */
  def scores(o: T): DoubleCounter[L];
}
