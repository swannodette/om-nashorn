(defproject nash-react "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2173"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [om "0.5.2-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "1.0.2"]]

  :source-paths ["src"]

  :cljsbuild { 
    :builds [{:id "nash-react"
              :source-paths ["src"]
              :compiler {
                :output-to "main.js"
                :output-dir "out"
                :optimizations :none
                :source-map true}}
             {:id "nash-react-simp"
              :source-paths ["src"]
              :compiler {
                :output-to "main.js"
                :output-dir "out-simp"
                :optimizations :simple}}
             {:id "nash-react-adv"
              :source-paths ["src"]
              :compiler {
                :output-to "main.js"
                :output-dir "out-adv"
                :pretty-print false
                :elide-asserts true
                :optimizations :advanced
                :preamble ["patch_react.js" "react/react.min.js"]
                :externs ["react/externs/react.js"]}}]})
