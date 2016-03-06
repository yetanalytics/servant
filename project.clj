(defproject servant "0.1.5"
  :source-paths ["src/cljs"]
  :description "A Clojurescript Library for interacting with webworkers sanely"
  :url "https://github.com/MarcoPolo/Servant"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [org.clojure/core.async "0.2.374"]
                 [com.cemerick/clojurescript.test "0.0.4"] ]
  :plugins [[lein-cljsbuild "1.1.2"]]
  :cljsbuild
              {:builds
               [{:id "servant"
                 :source-paths ["src/cljs/servant"]
                 :compiler {:optimizations :advanced
                            :pretty-print false
                            :output-to "main.js"
                            :source-map "main.js.map"
                            }}
                {:id "tests"
                 :source-paths ["src" "test"]
                 :compiler {:output-to "target/cljs/testable.js"
                            :source-map "target/cljs/testable.js.map"
                            :optimizations :simple
                            :pretty-print true}} ]
               :test-commands {"tests" ["phantomjs" "target/cljs/testable.js"]}})
