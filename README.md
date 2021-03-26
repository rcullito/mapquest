# mapquest

[![cljdoc badge](https://cljdoc.org/badge/mapquest/mapquest)](https://cljdoc.org/d/mapquest/mapquest/CURRENT)

a tiny clojure library of functions and macros for dealing with maps

## Rationale

`merge-left` - useful when the desired behavior is for keys to be preserved in a left to right manner

```
(merge-left 
    {:emergency-contact "917-283-3482"} 
    {:emergency-contact "911"}) 
=> {:emergency-contact "917-283-3482"}
```


`reset-index` - takes a map, and assigns its values to keys starting from 0

```
(reset-index {3 "rock" 4 "pebble" 6 "stone"}) 
=> {0 "rock" 1 "pebble" 2 "stone"}
```


`embellish` - if test is truthy, assoc k and v onto map, else return map

```
(let [hungry? true]
  (embellish
   hungry?  :food "purina"
   {:dog "claire"}))
=> {:dog "claire" :food "purina"}

(let [hungry? false]
  (embellish
   hungry? :food "mcdonalds"
   {:dog "claire"}))
=> {:dog "claire"}
```


`keyword-in-set` - macro to create one-off predicates that check a key in a map against set membership

```
;; define predicate
(keyword-in-set 
    valid-suite? 
    :suite 
    #{"hearts" "spades" "clubs" "diamonds"})
=> #'user/keyword-in-set

;; call predicate on example map
(valid-suite? {:suite "spades" :rank "king"}) 
=> "spades"

;; call predicate on another example map
(valid-suite? {:suite "circles" :rank 8}) 
=> nil 
```


## License

Copyright © 2021 

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
