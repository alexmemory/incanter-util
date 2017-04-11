(ns incanter-util.core
  "Utility functions for Incanter."
  (:require
   [clojure.data.csv :as csv]
   [clojure.java.io :as io]
   [clojure.set :as cs]
   [incanter.core :as in]))

(defn dataset-difference
  "Return a dataset with rows in the first dataset that are not in the
  second. The two datasets must have the same columns."
  [dataset1 dataset2]
  (let [diff (seq (cs/difference
                   (set (:rows dataset1))
                   (set (:rows dataset2))))]
    (in/dataset (keys (first diff)) diff)))

(defn dataset-drop-duplicates
  "Drop duplicate rows in a dataset."
  [dataset]
  (in/dataset
   (:column-names dataset)
   (distinct (:rows dataset))))

(defn dataset-from-org 
  "Convert an Org mode table into an Incanter dataset. Use
  the :colnames no header argument in Org to retain the header row."
  [table]
  (let [header (map keyword (first table))
        rows (rest table)]
    (in/dataset header rows)))

(defn dataset-intersection
  "Return a dataset with rows in the intersection of the rows of two
  datasets.  The two datasets must have the same columns."
  [dataset1 dataset2]
  (let [inters (seq (cs/intersection
                     (set (:rows dataset1))
                     (set (:rows dataset2))))]
    (in/dataset (keys (first inters)) inters)))

(defn dataset-join-natural
  "Return the natural join of two datasets. The two must have column names 
  in common.  This uses clojure.set/join."
  [dataset1 dataset2]
  (in/to-dataset (cs/join (:rows dataset1) (:rows dataset2))))

;;; TODO Use something else? Datomic?
;; (defn dataset-join-natural-right
;;   "Return the right natural join of two datasets. The two must have
;;   column names in common.  This uses clojure.set/join."
;;   [dataset1 dataset2]
;;   (in/to-dataset (cs/join (:rows dataset1) (:rows dataset2))))

(defn dataset-to-csv
  "Write a dataset to a CSV file."
  [ds out-path]
  (with-open [fout (io/writer out-path)]
    (csv/write-csv fout [(map name (in/col-names ds))])
    (csv/write-csv fout (in/to-list ds))))


