(defproject nash-react "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [org.clojure/core.async "0.2.371"]
                 [org.omcljs/om "1.0.0-alpha22" :exclusions [cljsjs/react cljsjs/react-dom]]
                 [cljsjs/react "0.14.3-0"]
                 [cljsjs/react-dom "0.14.3-1"]
                 [cljsjs/react-dom-server "0.14.3-0"]]

  :plugins [[lein-cljsbuild "1.1.1"]]

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
