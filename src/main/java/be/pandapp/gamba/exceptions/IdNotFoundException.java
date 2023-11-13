package be.pandapp.gamba.exceptions;

public class IdNotFoundException extends RuntimeException
{
    public IdNotFoundException(Long id)
    {
        super("l'element d'id "+id+" n'existe pas");
    }
}