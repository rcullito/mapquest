# mapquest

a tiny clojure library of functions and macros for dealing with maps

## Rationale

`merge-left` - useful when the desired behavior is for keys to be preserved in a left to right manner

```
(merge-left {:emergency-contact "917-283-3482"} {:emergency-contact "911"}) => {:emergency-contact "917-283-3482"}
```


`reset-map-index` - takes a map, strips the values, and then assigns those values to keys starting from 0

```
(reset-map-index {3 "rock" 4 "pebble" 6 "stone"}) => {0 "rock" 1 "pebble" 2 "stone"}
```


`keyword-in-set` - macro to create one-off helper fns that check a key in a map against set membership

```
(keyword-in-set valid-suite? :suite #{"hearts" "spades" "clubs" "diamonds"})

(valid-suite? {:suite "spades" :rank "king"}) => "spades"
(valid-suite? {:suite "circles" :rank 8}) => nil 
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
