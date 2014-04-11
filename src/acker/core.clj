(ns acker.core)

(declare ack-1)
(defn ack-1
  "The Ackermann function."
  [m n]
  (cond
    (zero? m) (inc n)
    (zero? n) (recur (dec m) 1)
    :else (ack-1 (dec m) (ack-1 m (dec n)))))

(declare ack-2)
(defn ack-2
  "The Ackermann function in continuation-passing style.
  Thanks to Allan Malloy's post at:
  http://grokbase.com/p/gg/clojure/127rbk4518/reduction-to-tail-recursion"
  ([m n]
   (ack-2 m n identity))
  ([m n cont]
   (cond
     (zero? m) (cont (inc n))
     (zero? n) (recur (dec m) 1 cont)
     :else (recur m (dec n) #(ack-2 (dec m) % cont)))))

(declare ack-3)
(defn ack-3
  "The Ackermann function using a stack and only tail recursion.
  Thanks to Allan Malloy's post at:
  http://grokbase.com/p/gg/clojure/127rbk4518/reduction-to-tail-recursion"
  [m n]
  (loop [m m n n stack ()]
    (cond
      (zero? m)
      (if (empty? stack)
        (inc n)
        (recur (peek stack) (inc n) (pop stack)))
      (zero? n) (recur (dec m) 1 stack)
      :else (recur m (dec n) (conj stack (dec m))))))
