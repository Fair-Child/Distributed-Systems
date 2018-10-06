/* 
    MIT License

    Copyright (c) 2018 Chris Mc, prince.chrismc(at)gmail(dot)com

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
 */
package Interface;

import Models.Project;
import java.io.Serializable;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author c_mcart
 */
public interface RegionalRecordManipulator extends Remote {

    // TO DO : Complete API
    //public void createMRecord (String firstName, String lastName, int employeeID, String mailID, Project projects) throws RemoteException;
    //public void createERecord (String firstName, String lastName, int employeeID, String mailID, String projectId, String location) throws RemoteException;
    
    public int getRecordCount() throws RemoteException;

    //public void editRecord( String recordID, String feildName, Serializable newValue );
}