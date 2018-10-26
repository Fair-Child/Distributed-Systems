package DEMS;


/**
* DEMS/RemoteExceptionHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from RegionalRecordManipulator.idl
* Thursday, October 25, 2018 9:48:52 o'clock PM EDT
*/

abstract public class RemoteExceptionHelper
{
  private static String  _id = "IDL:DEMS/RemoteException:1.0";

  public static void insert (org.omg.CORBA.Any a, DEMS.RemoteException that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static DEMS.RemoteException extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [1];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "what",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_exception_tc (DEMS.RemoteExceptionHelper.id (), "RemoteException", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static DEMS.RemoteException read (org.omg.CORBA.portable.InputStream istream)
  {
    DEMS.RemoteException value = new DEMS.RemoteException ();
    // read and discard the repository ID
    istream.read_string ();
    value.what = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, DEMS.RemoteException value)
  {
    // write the repository ID
    ostream.write_string (id ());
    ostream.write_string (value.what);
  }

}
