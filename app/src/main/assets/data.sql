SELECT flowers.*, bouquet_flower.amount_flower FROM bouquets
INNER JOIN bouquet_flower
ON bouquets.id = bouquet_flower.bouquet_id
INNER JOIN flowers
ON bouquet_flower.flower_id = flowers.id
WHERE bouquets.id = 1