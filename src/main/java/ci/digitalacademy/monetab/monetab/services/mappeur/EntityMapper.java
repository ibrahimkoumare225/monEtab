package ci.digitalacademy.monetab.monetab.services.mappeur;

public interface EntityMapper<D,E> {

    D toDto(E entity);
    E toEntity(D dto);
}
