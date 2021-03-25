# mapquest

a tiny clojure library of functions and macros for dealing with maps

## Rationale

merge-left - useful when the desired behavior is for keys to be preserved in a left to right manner


keyword-in-set - as it is common to pass around a map of data, and check a value in this map against set membership, this helper macro takes the name of a one-off predicate, the key of the map that we will care about, and the set to test that key's value against



```
(keyword-in-set valid-suite? :suite #{"hearts" "spades" "clubs" "diamonds"})

(valid-suite? {:suite "spades"}) => "spades"
(valid-suite? {:suite "circles"}) => nil 
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
