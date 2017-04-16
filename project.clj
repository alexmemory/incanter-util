(defproject org.clojars.alexmemory/incanter-util "0.1.0"
  :description "Utilities for Incanter"
  :url "https://github.com/alexmemory/incanter-util"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/data.csv "0.1.3"]
                 [org.clojars.alexmemory/clj-util "0.1.0"]
                 [incanter/incanter-core "1.5.6"]
                 [incanter/incanter-io "1.5.6"]]
  :aot :all
  :pedantic :warn                       ; Class path warnings
  )
