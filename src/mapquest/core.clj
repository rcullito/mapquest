(ns mapquest.core)


(defn merge-left
  "preserves keys in earlier maps"
  [& maps]
  (apply merge (reverse maps)))

(defn reset-index
  "takes a map, and assigns its values to keys starting from 0"
  [map]
  (zipmap (range) (vals map)))

(defmacro embellish
  "if test is truthy, assoc k and v onto map, else return map"
  [test k v m]
  `(cond-> ~m
     ~test (assoc ~k ~v)))

(defmacro keyword-in-set
  "defines a predicate that accepts a map, and tests a key from that map for set membership"
  [name k set]
  `(defn ~(symbol name) [m#]
     (~set (~k m#))))

