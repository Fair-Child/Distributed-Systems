package DEMS;

/**
* DEMS/RemoteExceptionHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from RegionalRecordManipulator.idl
* Thursday, October 25, 2018 9:48:52 o'clock PM EDT
*/

public final class RemoteExceptionHolder implements org.omg.CORBA.portable.Streamable
{
  public DEMS.RemoteException value = null;

  public RemoteExceptionHolder ()
  {
  }

  public RemoteExceptionHolder (DEMS.RemoteException initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DEMS.RemoteExceptionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DEMS.RemoteExceptionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DEMS.RemoteExceptionHelper.type ();
  }

}
