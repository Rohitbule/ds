import paho.mqtt.client as mqtt
import time

BROKER = "test.mosquitto.org"  # Public broker for testing
TOPIC = "example/pubsub"

def publish_message():
    client = mqtt.Client()
    client.connect(BROKER, 1883, 60)
    while True:
        message = input("Enter a message to publish: ")
        client.publish(TOPIC, message)
        print(f"Published: {message}")
        time.sleep(1)

if __name__ == "__main__":
    publish_message()



























"""
Broker:
You are using a public MQTT broker (test.mosquitto.org) that acts as an intermediary for transmitting messages between the publisher and subscriber.

Publisher (publish_message function):
The publisher connects to the MQTT broker.
It enters a loop where it prompts the user to input a message.
It then publishes that message to the specified topic (example/pubsub).
After each message is published, it waits for 1 second (time.sleep(1)) before repeating.

Subscriber (subscribe_messages function):
The subscriber connects to the same MQTT broker.
It subscribes to the same topic (example/pubsub).
The on_message callback function is triggered whenever a message is published to the subscribed topic.
It prints the received message.
The loop_forever() method keeps the client listening for new messages indefinitely.

Running the Code:
Run python subscriber.py in one terminal window to start listening for messages.
Run python publisher.py in another terminal window to publish messages.
The subscriber will receive and print any message published by the publisher.

Publisher and Subscriber in Distributed Systems:
In distributed systems, a publisher-subscriber model is a messaging pattern where:
Publisher: A component that sends messages without needing to know who will receive them. 
           It simply publishes messages to a specific "topic."
Subscriber: A component that listens for messages from specific topics of interest. 
            It subscribes to those topics and receives updates whenever new messages are published.

Advantages:
Decoupling: Publishers and subscribers are not aware of each other. This promotes scalability and flexibility.
Asynchronous communication: Subscribers can process messages independently as they arrive, without waiting for the publisher.
Distributed nature: This model works well across distributed networks and is often used in IoT systems, message queuing, and real-time data distribution.
MQTT (Message Queuing Telemetry Transport) is often used in distributed systems due to its lightweight protocol, low bandwidth usage, and efficiency in scenarios like IoT, where devices may have limited resources.
"""