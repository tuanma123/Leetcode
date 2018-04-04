SELECT W.name, w.population, w.area
FROM World AS W
WHERE W.population > 25000000 OR W.area > 3000000;