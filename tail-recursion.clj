;clojure does not support tail call optimization in its natural form
;because of this the following will use 'normal' recursion, building up stacks
;until a stackoverflow occurs
(defn countstackoverflow [x]
  (do
    (println x)
    (countstackoverflow (inc x))));

;each time recur is hit, the loop function is called again with the new value of x
;which is increased each call, creating an infinite counter
(defn countinfinite []
  (loop [x 0]
    (println x)
    (recur (inc x))))

;same as above except with an exit condition when x reaches the max value
(defn countlimited [max]
  (loop [x 0]
      (println x)
      (if (< x max)
        (recur (inc x))
        ())))


(countstackoverflow 0)
(countlimited 100)
(countinfinite)
