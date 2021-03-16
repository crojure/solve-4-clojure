(ns solve-4-clojure.elementary)

;; Regular Expressions
(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

;; Rearranging Code ->
(= (count (sort (rest (reverse [2 5 4 1 3 6]))))
   (-> [2 5 4 1 3 6]
       (reverse)
       (rest)
       (sort)
       (count))
   5)

;; Recurring Theme
(= [7 6 5 4 3]
   (loop [x 5
          result []]
     (if (> x 0)
       (recur (dec x) (conj result (+ 2 x)))
       result)))

;; Rearranging Code ->>
(= (reduce + (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
   (->> [2 5 4 1 3 6]
        (drop 2)
        (take 3)
        (map inc)
        (reduce +))
   11)