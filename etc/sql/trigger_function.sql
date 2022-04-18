-- INSERT
CREATE OR REPLACE FUNCTION calcular_valor_total()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
AS $$
BEGIN
	UPDATE pedido
	SET valor_total = COALESCE(valor_total, 0) + (NEW.valor_unidade * NEW.qtd)
	WHERE id_pedido = NEW.id_pedido;
	RETURN NULL;
END;
$$;

CREATE TRIGGER trigger_atualizar_valor_pedido
	AFTER INSERT
	ON pedido_produto
	FOR EACH ROW
	EXECUTE PROCEDURE calcular_valor_total();

-- UPDATE
CREATE OR REPLACE FUNCTION calcular_valor_total_update()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
AS $$
BEGIN
	UPDATE pedido
	SET valor_total = COALESCE(valor_total, 0) - (OLD.valor_unidade * OLD.qtd) + (NEW.valor_unidade * NEW.qtd)
	WHERE id_pedido = NEW.id_pedido;
	RETURN NULL;
END;
$$;

CREATE TRIGGER trigger_atualizar_valor_pedido_update
	AFTER UPDATE
	ON pedido_produto
	FOR EACH ROW
	EXECUTE PROCEDURE calcular_valor_total_update();

-- DELETE
CREATE OR REPLACE FUNCTION calcular_valor_total_delete()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
AS $$
BEGIN
	UPDATE pedido
	SET valor_total = COALESCE(valor_total, 0) - (OLD.valor_unidade * OLD.qtd)
	WHERE id_pedido = OLD.id_pedido;
	RETURN NULL;
END;
$$;

CREATE TRIGGER trigger_atualizar_valor_pedido_delete
	AFTER DELETE
	ON pedido_produto
	FOR EACH ROW
	EXECUTE PROCEDURE calcular_valor_total_delete();