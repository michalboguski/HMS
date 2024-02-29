package pl.michalboguski.HMS;

public interface Mapper<D,E>{
     D toDto(E entity);
     E toEntity(D dto);
}
