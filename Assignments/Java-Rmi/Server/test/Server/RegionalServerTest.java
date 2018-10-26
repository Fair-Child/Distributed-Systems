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
package Server;

import Interface.Rmi.RegionalRecordManipulator;
import Rmi.Server.RmiRegionalServer;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author cmcarthur
 */
public class RegionalServerTest {

    static private Registry registry;

    public RegionalServerTest() {
    }

    @BeforeClass
    static public void setupRegistry() throws RemoteException {
        registry = LocateRegistry.createRegistry(12345);
    }

    @Test
    public void canLaunchServer() throws RemoteException, IOException {
        RmiRegionalServer UnitedStates = new RmiRegionalServer(TestRegion.US);
        registry.rebind("canLaunchServer", UnitedStates);
        UnitedStates.Start();
    }

    @Test
    public void canLookupServer() throws RemoteException, NotBoundException, IOException {
        RmiRegionalServer Canada = new RmiRegionalServer(TestRegion.CA);
        registry.rebind(Canada.getUrl(), Canada);

        RegionalRecordManipulator Remote = (RegionalRecordManipulator) registry.lookup("rmi://localhost/" + TestRegion.CA.toString());

        Assert.assertNotEquals("Remote Interface must be obtained", null, Remote);
    }

    @Test
    public void canGetRecordCount() throws Exception {
        RmiRegionalServer UnitedKingdom = new RmiRegionalServer(TestRegion.UK);
        UnitedKingdom.Start();

        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        Message request = new Message(OperationCode.GET_RECORD_COUNT, "", address, TestRegion.UK.toInt());

        socket.send(request.getPacket());

        byte[] buf = new byte[256];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        socket.setSoTimeout(1000); // Set timeout in case packet is lost
        socket.receive(packet);

        Message response = new Message(packet);

        assertEquals("Get Record cound must be answered with an ACK", OperationCode.ACK_GET_RECORD_COUNT, response.getOpCode());
        assertEquals("UK RS should have Zero records", "UK 0", TestRegion.UK.getPrefix() + " " + response.getData());
    }

    @Test
    public void canUpdateEmployeeId() throws Exception {
        RmiRegionalServer UnitedKingdom = new RmiRegionalServer(TestRegion.TK);
        UnitedKingdom.Start();

        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        Message request = new Message(OperationCode.UPDATE_RECORD_INDEX, "ER30002", address, TestRegion.TK.toInt());

        socket.send(request.getPacket());

        byte[] buf = new byte[256];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        socket.setSoTimeout(1000); // Set timeout in case packet is lost
        socket.receive(packet);

        Message response = new Message(packet);

        assertEquals("Get next id must be answered with an ACK", OperationCode.ACK_UPDATE_RECORD_INDEX, response.getOpCode());
        assertEquals("RS should have accepted new ID", "ER30002", response.getData());
    }

    @Test
    public void canUpdateManagerId() throws Exception {
        RmiRegionalServer UnitedKingdom = new RmiRegionalServer(TestRegion.AU);
        UnitedKingdom.Start();

        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        Message request = new Message(OperationCode.UPDATE_RECORD_INDEX, "MR96792", address, TestRegion.AU.toInt());

        socket.send(request.getPacket());

        byte[] buf = new byte[256];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        socket.setSoTimeout(1000); // Set timeout in case packet is lost
        socket.receive(packet);

        Message response = new Message(packet);

        assertEquals("Get next id must be answered with an ACK", OperationCode.ACK_UPDATE_RECORD_INDEX, response.getOpCode());
        assertEquals("RS should have accepted new ID", "MR96792", response.getData());
    }
}