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

;; Replicate a Sequence
(defn replicate-seq [values n]
  (reduce concat (map #(map (fn [_] %) (range 0 n)) values)))

(replicate-seq [1 2 3] 2)

(replicate-seq [[1 2] [3 4]] 2)

(= (replicate-seq [1 2 3] 2) '(1 1 2 2 3 3))

(defn my-interleave [val values]
  (pop (reduce #(conj (conj %1 %2) val) [] values)))

(my-interleave 0 [1 2 3])

;; Drop every nth item
(defn drop-every-nth [vec n]
  (loop [source vec
         dest []]
    (if (empty? source)
      (flatten dest)
      (recur (drop n source) (conj dest (take (dec n) source))))))

(drop-every-nth [1 2 3 4 5 6 7 8] 3)