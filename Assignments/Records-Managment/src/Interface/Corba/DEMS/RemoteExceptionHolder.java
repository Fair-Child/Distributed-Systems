package Interface.Corba.DEMS;

/**
* DEMS/RemoteExceptionHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from RegionalRecordManipulator.idl
* Thursday, October 25, 2018 9:48:52 o'clock PM EDT
*/

public final class RemoteExceptionHolder implements org.omg.CORBA.portable.Streamable
{
  public RemoteException value = null;

  public RemoteExceptionHolder ()
  {
  }

  public RemoteExceptionHolder (RemoteException initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = RemoteExceptionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    RemoteExceptionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return RemoteExceptionHelper.type ();
  }

}
