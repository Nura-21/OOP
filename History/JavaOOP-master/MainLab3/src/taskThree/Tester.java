package taskThree;

public class Tester {

	public static void main(String[] args) {
		VectorPro vp = new VectorPro();
		vp.push_back(1);
		vp.push_back(4);
		vp.push_back(3);
		vp.push_back(2);
		vp.push_back(5);
		System.out.println("ToString: " + vp + " Size: " + vp.size());
		System.out.println("Front: " + vp.front());
		System.out.println("Back: " + vp.back());
		System.out.println("Get index element: " + vp.at(2));
		vp.pop_back();
		System.out.println("After pop_back " + vp + " Size: " + vp.size());
		vp.reverse();
		System.out.println("After reverse " + vp + " Size: " + vp.size());
		vp.sort(0, vp.size());
		System.out.println("After sort " + vp + " Size: " + vp.size());
		vp.insert(2, 10);
		System.out.println("After inserting " + vp + " Size: " + vp.size());
		vp.removeElement(3);
		System.out.println("After removing element " + vp + " Size: " + vp.size());
		vp.removeAtIndex(1);
		System.out.println("After removing at index " + vp + " Size: " + vp.size());
		vp.set(2, 30);
		System.out.println("After set " + vp + " Size: " + vp.size());
		System.out.println("Find element 10, index: " + vp.find(10));
		vp.clear();
		System.out.println("After clear " + vp + " Size: " + vp.size());
	}

}
//OUTPUT
//ToString: VectorPro: {1, 4, 3, 2, 5} Size: 5
//Front: 1
//Back: 5
//Get index element: 3
//After pop_back VectorPro: {1, 4, 3, 2} Size: 4
//After reverse VectorPro: {2, 3, 4, 1} Size: 4
//After sort VectorPro: {1, 2, 3, 4} Size: 4
//After inserting VectorPro: {1, 2, 10, 3, 4} Size: 5
//After removing element VectorPro: {1, 2, 10, 4} Size: 4
//After removing at index VectorPro: {1, 10, 4} Size: 3
//After set VectorPro: {1, 10, 30} Size: 3
//Find element 10, index: 1
//After clear VectorPro: {} Size: 0
