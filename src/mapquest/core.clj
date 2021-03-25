(ns mapquest.core)


(defn merge-left
  "preserves keys in earlier maps"
  [& maps]
  (apply merge (reverse maps)))

(defn reset-map-index
  "takes a map, strips the values, and then assigns those values to keys starting from 0"
  [map-of-things]
  (zipmap (range) (vals map-of-things)))



(reset-map-index {3 "rock" 4 "pebble" 6 "stone"})


(defmacro embellish
  "if test is truthy, assoc k and v onto map, else return map"
  [test m k v]
  `(cond-> ~m
     ~test (assoc ~k ~v)))


(embellish (= 5 5)
           {:dog "claire"} :food "purina")


(defmacro keyword-in-set
  "defines a predicate that accepts a map, and tests a key from that map for set membership"
  [name k set]
  `(defn ~(symbol name) [m#]
     (~set (~k m#))))

(keyword-in-set valid-suite? :suite #{"hearts" "spades" "clubs" "diamonds"})

(valid-suite? {:suite "spades" :rank "king"})
(valid-suite? {:suite "circles" :rank 8})

