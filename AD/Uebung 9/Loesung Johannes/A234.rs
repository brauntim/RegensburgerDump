#![allow(dead_code)]

use std::fmt::Debug;

#[derive(Debug, Clone, PartialEq)]
enum HashMapElement<T> {
  Empty,
  Deleted,
  Value(T)
}

struct HashMap<T, F1, F2>
where
  T: Eq + Debug,
  F1: Fn(&T) -> usize,
  F2: Fn(usize, usize) -> usize,
{
  table: Vec<HashMapElement<T>>,
  h1: F1,
  h2: F2,
}

impl<T, F1, F2> HashMap<T, F1, F2>
where
    T: Eq + Debug,
    F1: Fn(&T) -> usize,
    F2: Fn(usize, usize) -> usize,
{
  fn new(m: usize, h1: F1, h2: F2) -> HashMap<T, F1, F2> {
    HashMap {
      table: (0..m).map(|_| HashMapElement::Empty).collect(),
      h1,
      h2,
    }
  }

  fn insert(&mut self, value: T) {
    let mut pos = (self.h1)(&value) % self.table.len();

    let mut attempt = 1;
    while self.table[pos] != HashMapElement::Empty {
      pos = (self.h2)(pos, attempt) % self.table.len();
      attempt += 1;
    }

    self.table[pos] = HashMapElement::Value(value);
  }

  fn contains(&self, value: &T) -> bool {
    let mut pos = (self.h1)(&value) % self.table.len();

    let mut attempt = 1;
    loop {
      if self.table[pos] == HashMapElement::Empty {
        return false;
      }
      if let HashMapElement::Value(v) = &self.table[pos] {
        if v == value {
          return true;
        }
      }
      pos = (self.h2)(pos, attempt) % self.table.len();
      attempt += 1;
    }
  }

  fn delete(&mut self, value: &T) {
    let mut pos = (self.h1)(&value) % self.table.len();

    let mut attempt = 1;
    loop {
      if self.table[pos] == HashMapElement::Empty {
        return;
      }
      if let HashMapElement::Value(v) = &self.table[pos] {
        if v == value {
          self.table[pos] = HashMapElement::Deleted;
          return;
        }
      }
      pos = (self.h2)(pos, attempt) % self.table.len();
      attempt += 1;
    }
  }
  
  fn print_table(&self, print_empty: bool) {
    println!("Table size: {}", self.table.len());
    for (i, elem) in self.table.iter().enumerate() {
      match elem {
        HashMapElement::Empty => if print_empty { println!("  {}: Empty", i) },
        HashMapElement::Deleted => println!("  {}: Deleted", i),
        HashMapElement::Value(v) => println!("  {}: Value({:?})", i, v),
      }
    }
  }
}

fn a2() {
  let m = 1000;
  let nums = vec![61, 62, 63, 64, 65];

  let x = (5f64.sqrt() - 1.0) / 2.0;

  let h1 = |val: &i32| -> usize {
    (m as f64 * ((*val as f64 * x) % 1.0)) as usize
  };
  let h2 = |pos: usize, attempt: usize| -> usize {
    // Linear probing
    pos + attempt
  };

  let mut hash_map = HashMap::new(m, h1, h2);

  for num in &nums {
    hash_map.insert(*num);
  }

  for num in &nums {
    assert!(hash_map.contains(&num));
  }

  hash_map.print_table(false);
}

// a3: Die Formel beschreibt die Wahrscheinlichkeit, dass genau k aus n Elementen auf den gleichen Platz fallen würden.

fn a4() {
  let m = 11;
  let nums = vec![10, 22, 31, 4, 15, 28, 17, 88, 59];

  let h1 = |val : &i32| -> usize {
    *val as usize
  };

  let h2_lin = |pos: usize, attempt: usize| -> usize {
    // Linear probing
    pos + attempt
  };
  let h2_quad = |pos: usize, attempt: usize| -> usize {
    // Quadratic probing
    let c1 = 1;
    let c2 = 3;

    pos as usize + c1 + 2 * c2 * attempt + 1
  };
  let h2_doub = |pos: usize, _: usize| -> usize {
    // Double hashing
    1 + (pos % (m - 1)) as usize
  };

  let mut hash_map_lin = HashMap::new(m, h1, h2_lin);
  let mut hash_map_quad = HashMap::new(m, h1, h2_quad);
  let mut hash_map_doub = HashMap::new(m, h1, h2_doub);

  for num in &nums {
    hash_map_lin.insert(*num);
    hash_map_quad.insert(*num);
    hash_map_doub.insert(*num);
  }

  println!("\nLinear probing:");
  hash_map_lin.print_table(false);

  println!("\nQuadratic probing:");
  hash_map_quad.print_table(false);

  println!("\nDouble hashing:");
  hash_map_doub.print_table(false);
}

fn main() {
  println!("Aufgabe 2:\n");
  a2();

  println!("\n\nAufgabe 4:");
  a4();
}