import Item from './Item'


const array = [1,2,3]


const List = () => {
    return <div className="list">
        {
            array.map(item => <Item />)
        }
        {/* <Item /> */}
        </div>
};

export default List;