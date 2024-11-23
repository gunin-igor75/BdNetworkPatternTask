SELECT flowers.*, bouquet_flower.amount_flower FROM bouquets
INNER JOIN bouquet_flower
ON bouquets.id = bouquet_flower.bouquet_id
INNER JOIN flowers
ON bouquet_flower.flower_id = flowers.id
WHERE bouquets.id = 1

SELECT (warehouse.amount - bouquet_flower.amount_flower) as reminder,
warehouse.id
FROM bouquet_flower
INNER JOIN flowers
ON bouquet_flower.flower_id = flowers.id
INNER JOIN warehouse
ON flowers.id = warehouse.flower_id
WHERE bouquet_flower.bouquet_id = 2;