package DEMS;

/**
* DEMS/RegionalRecordManipulatorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from RegionalRecordManipulator.idl
* Thursday, October 25, 2018 9:48:52 o'clock PM EDT
*/

public final class RegionalRecordManipulatorHolder implements org.omg.CORBA.portable.Streamable
{
  public DEMS.RegionalRecordManipulator value = null;

  public RegionalRecordManipulatorHolder ()
  {
  }

  public RegionalRecordManipulatorHolder (DEMS.RegionalRecordManipulator initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DEMS.RegionalRecordManipulatorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DEMS.RegionalRecordManipulatorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DEMS.RegionalRecordManipulatorHelper.type ();
  }

}
