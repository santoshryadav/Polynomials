;;poly-maker returns the function to calculate the value of polynomial

(def example (poly-maker [[3 2] [2 1]]))

(defn poly-maker [list]
  (fn [n]
    (if (empty? list)
      0
      (sum n list)
    )
  )
)

;;Intermediate function

(defn sum [n list]

  (if (empty? list)
    0
   (+ (* (first (first list)) (java.lang.Math/pow n (second (first list)))) (sum n (rest list)))
  )
)

(example 2)