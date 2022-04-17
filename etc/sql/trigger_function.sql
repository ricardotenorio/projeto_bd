CREATE FUNCTION calcular_valor_total()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
AS $$
BEGIN
	SELECT sum(pp.valor_unidade * pp.qtd) INTO valor_total_temp
		FROM pedido_produto AS pp
		WHERE pp.id_pedido = NEW.id_pedido
		GROUP BY pp.id_pedido;

	NEW.valor_total := valor_total_temp;
END;
$$

CREATE TRIGGER trigger_valor_total
	AFTER INSERT
	ON produto
	FOR EACH ROW
	EXECUTE PROCEDURE calcular_valor_total();