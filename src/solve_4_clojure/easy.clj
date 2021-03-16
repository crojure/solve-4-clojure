(ns solve-4-clojure.easy)

;; Interleave 2 Seqs
(defn my-interleave [vec1 vec2]
  (loop [v1 vec1
         v2 vec2
         result []]
    (if (or (empty? v1) (empty? v2))
      result
      (recur (rest v1) (rest v2) (conj (conj result (first v1)) (first v2))))))

(= (my-interleave [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
