
CREATE TABLE comentarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    topico_id BIGINT NOT NULL,
    comentario TEXT NOT NULL,
    autor VARCHAR(255) NOT NULL,
    fecha DATETIME NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_comentarios_topico_id FOREIGN KEY (topico_id) REFERENCES topicos(id)
);