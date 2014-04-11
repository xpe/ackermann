(defproject acker "0.1.0-SNAPSHOT"
  :description "Ackermann function implementations in Clojure"
  :url "http://github.com/bluemont/ackermann"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :test-selectors {:default (complement :slow)
                   :slow :slow
                   :all (constantly true)})
