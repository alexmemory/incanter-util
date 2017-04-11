(defproject org.clojars.alexmemory/incanter-util "0.1.0-SNAPSHOT"
  :description "Utilities for Incanter"
  :dependencies [;; [org.clojure/clojure "1.8.0"]
                 [org.clojars.alexmemory/clj-util "0.1.0-SNAPSHOT"]
                 [incanter/incanter-core "1.5.6"
                  ;; Interferes with PSL, IIRC
                  ;; :exclusions [net.sourceforge.jplasma/jplasma]
                  ]
                 [incanter/incanter-io "1.5.6"]
                 ])
